<template>
  <div class="form-container">
    <h2 class="form-title">User Information</h2>
    <div class="form-group">
      <label for="name" class="form-label">Name:</label>
      <input
        v-model="name"
        id="name"
        type="text"
        class="form-input"
        placeholder="Enter your name"
      />
    </div>

    <div class="form-group">
      <label for="age" class="form-label">Age:</label>
      <input
        v-model.number="age"
        id="age"
        type="number"
        class="form-input"
        placeholder="Enter your age"
      />
    </div>

    <div class="form-group">
      <label for="email" class="form-label">Email:</label>
      <input
        v-model.number="email"
        id="email"
        type="text"
        class="form-input"
        placeholder="Enter your email"
      />
    </div>

    <button @click="submitForm" class="custom-button" v-if="!editmode">
      Submit
    </button>
    <button @click="updateUser" class="custom-button" v-if="editmode">
      Update
    </button>
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";
import { store } from "../store";

export default {
  name: "AddUser",
  data() {
    return {
      name: "",
      age: null,
      email: "",
      userId: null,
      editmode: false,
      isConnected: false,
      user: null,
    };
  },
  created() {
    this.userId = this.$route.params.id;
    this.checkConnection();
  },
  methods: {
    submitForm() {
      if (this.isConnected) {
        this.createUserInDatabase();
      } else {
        this.createUserInStore();
      }
    },
    getUserDetailsFromDatabase() {
      axios
        .get(`http://localhost:5000/user/${this.userId}`)
        .then((response) => {
          this.user = response.data;
          this.name = this.user.name;
          this.age = this.user.age;
          this.email = this.user.email;
        });
    },
    getUserDetailseFromStore() {
      const founduser = store.user.find(
        (user) => user.id.toString() === this.userId
      );
      this.name = founduser.name;
      this.age = founduser.age;
      this.email = founduser.email;
      this.editmode = true;
    },
    checkEditOrAddUser() {
      if (this.isConnected) {
        if (this.userId.toString() !== "-1") {
          this.getUserDetailsFromDatabase();
        }
      } else {
        if (this.userId.toString() !== "-1") {
          this.getUserDetailseFromStore();
        }
      }
    },
    updateUser() {
      const userData = {
        name: this.name,
        age: this.age,
        email: this.email,
      };

      if (this.isConnected) {
        axios
          .put(`http://localhost:5000/user/${this.userId}`, userData)
          .then((response) => {
            console.log("User data updated successfully:", response.data);
            this.name = "";
            this.age = null;
            this.email = "";
            store.updatedUserId = this.userId;
            this.$router.push("/");
          })
          .catch((error) => {
            console.error("Error updating user data:", error);
          });
      } else {
        const userDataa = {
          id: this.userId,
          name: this.name,
          age: this.age,
          email: this.email,
        };
        store.user[this.userId - 1] = userDataa;
        store.updatedUserId = this.userId;
        this.$router.push("/");
      }
    },
    checkConnection() {
      axios
        .get("http://localhost:5000/check-connection")
        .then((response) => {
          this.isConnected = true;
          this.checkEditOrAddUser();
        })
        .catch((error) => {
          this.isConnected = false;
          this.checkEditOrAddUser();
        });
    },
    createUserInDatabase() {
      const userData = {
        name: this.name,
        age: this.age,
        email: this.email,
      };

      axios
        .post("http://localhost:5000/user", userData)
        .then((response) => {
          console.log("User data submitted successfully:", response.data);
          // Reset form fields after successful submission
          this.name = "";
          this.age = null;
          this.email = "";
          store.newUserCreated= true;
          this.$router.push("/");
        })
        .catch((error) => {
          console.error("Error submitting user data:", error);
        });
    },
    createUserInStore() {
      store.id = store.id + 1;
      store.user.push({
        id: store.id,
        name: this.name,
        age: this.age,
        email: this.email,
      });
      store.newUserCreated= true;
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.form-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 30px;
  border: 1px solid #eaeaea;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #ffffff;
}

.form-title {
  font-size: 1.5rem;
  margin-bottom: 20px;
  color: #333333;
}

.form-group {
  margin-bottom: 20px;
}

.form-label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: #555555;
}

.form-input {
  width: 100%;
  padding: 10px;
  border: 1px solid #cccccc;
  border-radius: 3px;
}

.custom-button {
  display: inline-block;
  padding: 12px 20px;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: #ffffff;
  background-color: #3498db;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.custom-button:hover {
  background-color: #2980b9;
}

.custom-button:active {
  background-color: #1e6091;
}
</style>
