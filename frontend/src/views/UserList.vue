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
            <button @click="editUser(user)">Update</button>
            <button @click="delete(user.id)">Delete</button>
          </td>
        </tr>
        

      </tbody>
    </table>
  </div>
</template>

<script>
// @ is an alias to /src

import axios from 'axios';

export default {

  name: 'UserList',
  data() {
    return {
      userList: []
    };
  },
  created() {
    this.fetchData();
  },methods: {
    fetchData() {
      axios.get('http://localhost:8080/user')
        .then(response => {
          this.userList = response.data;
        })
        .catch(error => {
          console.error('Error fetching data:', error);
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
  padding: 8px;
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

button {
  padding: 5px 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
