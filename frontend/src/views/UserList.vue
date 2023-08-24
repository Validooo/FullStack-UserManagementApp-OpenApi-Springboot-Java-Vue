<template>
  <div>
    <table class="user-table">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Age</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in userList" :key="user.id">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.age }}</td>
          <td>{{ user.email }}</td>
        </tr>
        <td>
            <button @click="editUser(user)">Edit</button>
          </td>

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
