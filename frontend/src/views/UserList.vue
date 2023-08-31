<template>
  <div>
    <div class="alert-div-message" v-if="showErrorMessage">
      <b class="centered-element">{{ message }}</b>
    </div>
    <div class="update-div-message" v-if="showUpdateMessage">
      <b class="centered-element">{{ message }}</b>
    </div>
    <div class="create-div-message" v-if="showCreateMessage">
      <b class="centered-element">{{ message }}</b>
    </div>
  
    <table class="user-table">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Age</th>
          <th>Email</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in userList" :key="user.id">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.age }}</td>
          <td>{{ user.email }}</td>
          <td>
            <button @click="editUser(user.id)" class="update-button">
              Update
            </button>
            <button @click="deleteUser(user.id)" class="delete-button">
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <h2>test auto deploy</h2>
  </div>

  
</template>

<script>
// @ is an alias to /src

import axios from "axios";
import { store } from "../store";

export default {
  name: "UserList",
  data() {
    return {
      userList: [],
      isConnected: false,
      message: "",
      showErrorMessage: false,
      showUpdateMessage: false,
      showCreateMessage: false,
      updatedUserId: -1,
    };
  },
  created() {
    this.checkAndFetch();
  },
  methods: {
    async fetchData() {
      if (this.isConnected) {
        axios
          .get("http://localhost:5000/user")
          .then((response) => {
            this.userList = response.data;
            this.checkIfUserUpdated()
            this.checkIfUserCreate()
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        this.userList = store.user;
        this.checkIfUserUpdated()
        this.checkIfUserCreate()
      }
    },
    editUser(id) {
      this.$router.push(`/user/${id}`);
    },
    deleteUser(id) {
      if (this.isConnected) {
        axios
          .delete(`http://localhost:5000/user/${this.userId}`)
          .then((response) => {
            const founduser = this.getUserById(id);
            this.todos = this.todos.filter((todo) => todo.id !== id);
            this.message = `Delete User "${founduser.name}" with id="${id}"`;
            this.showErrorMessage = true;
            this.removeMessage();
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        const founduser = this.getUserById(id);
        const userListFiltered = store.user.filter(
          (person) => person.id !== id
        );
        store.user = userListFiltered;
        this.message = `Delete User "${founduser.name}" with id="${id}"`;
        this.fetchData();
        this.showErrorMessage = true;
        this.removeMessage();
      }
    },
    checkAndFetch() {
      axios
        .get("http://localhost:5000/check-connection")
        .then((response) => {
          this.isConnected = true;
          return this.fetchData();
        })
        .catch((error) => {
          this.isConnected = false;
          return this.fetchData();
        });
    },
    removeMessage() {
      setTimeout(() => {
        this.showErrorMessage = false;
        this.message = "";
        this.updatedUserId = -1;
        this.showUpdateMessage = false
        store.updatedUserId = -1;
        this.showCreateMessage = false,
        store.newUserCreated = false;
      }, 55000); // Delay of 3000 milliseconds (3 seconds)
    },
    checkIfUserUpdated() {
      if (store.updatedUserId !== -1) {
        const user = this.getUserById(store.updatedUserId)
        this.message = `Update User "${user.name}" with id="${store.updatedUserId}"`;
        this.showUpdateMessage = true
        this.removeMessage();
      }
    }, checkIfUserCreate(){
      console.log(store.newUserCreated)
if(store.newUserCreated === true){
this.message = `Create new User "${this.getLastUserCreated().name}" with id="${this.getLastUserCreated().id}"`
this.showCreateMessage = true;
this.removeMessage();
}
    }, 
    getUserById(id) {
      if (this.isConnected) {
        return this.todos.find((user) => user.id === id);
      } else {
        return store.user.find((user) => user.id === id);
      }
    }, getLastUserCreated(){
      return this.userList[this.userList.length-1];
    }
  },
};
</script>

<style>
.user-table {
  width: 100%;
  border-collapse: collapse;
  border: 1px solid #ccc;
  margin-top: 20px;
}

.user-table th,
.user-table td {
  padding: 4px;
  text-align: left;
  border: 1px solid #ccc;
}

.user-table th {
  background-color: #f5f5f5;
  font-weight: bold;
}

.user-table tbody tr:hover {
  background-color: #f0f0f0;
}

.update-button {
  display: inline-block;
  padding: 12px 20px;
  margin: 10px;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: #ffffff;
  background-color: #26a1ff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.update-button:hover {
  background-color: #1d84d3;
}

.delete-button {
  display: inline-block;
  padding: 12px 20px;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: #ffffff;
  background-color: #ff2929;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.delete-button:hover {
  background-color: #e41c1c;
}

.delete-button:active {
  background-color: #fc0909;
}

.alert-div-message {
  height: 50px;
  background-color: #ff3434;
  position: relative;
  justify-content: center;
  align-items: center;
  /* Additional styling */
}
.update-div-message {
  height: 50px;
  background-color: #ffd630;
  position: relative;
  justify-content: center;
  align-items: center;
  /* Additional styling */
}

.centered-element {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.create-div-message{
  height: 50px;
  background-color: #3dff6a;
  position: relative;
  justify-content: center;
  align-items: center;
  /* Additional styling */
}
</style>
