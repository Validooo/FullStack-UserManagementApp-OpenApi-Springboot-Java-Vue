<template>
  <div>
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
            <button @click="editUser(user.id)" class="update-button">Update</button>
            <button @click="deleteUser(user.id)" class="delete-button" >Delete</button>
          </td>
        </tr>
        

      </tbody>
    </table>
  </div>
</template>

<script>
// @ is an alias to /src

import axios from 'axios';
import {store} from '../store'

export default {

  name: 'UserList',
  data() {
    return {
      userList: [],
      isConnected: false
    };
  },
  created() {
    this.checkAndFetch();
  },methods: {
  async fetchData() {
    if(this.isConnected){
      axios.get('http://localhost:5000/user')
        .then(response => {
          this.userList = response.data;
        })
        .catch(error => {
          console.log(error) 
        });
    }else{
      this.userList = store.user;
    } },
    editUser(id){
      this.$router.push(`/user/${id}`);
    },
    deleteUser(id){
      if(this.isConnected){
        axios.delete(`http://localhost:5000/user/${this.userId}`)
        .then(response => {
          this.todos = this.todos.filter(todo => todo.id !== id);
        })
        .catch(error => {
          console.log(error) 
        });
      }else{
        const userListFiltered = store.user.filter(person => person.id !== id);
          store.user = userListFiltered
          this.fetchData();
      }
      
    },checkAndFetch(){
      axios.get('http://localhost:5000/check-connection')
        .then(response => {
          this.isConnected = true;
          return this.fetchData();
        })
        .catch(error => {
          this.isConnected = false;
          return this.fetchData();
        });
        
      }
  }

}
</script>

<style >
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

</style>
