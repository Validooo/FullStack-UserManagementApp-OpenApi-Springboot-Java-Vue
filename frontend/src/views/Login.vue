<template>
<div class="login-wrapper">
<div class="login-container">
    <h1 class="loginhtwo"> Login!</h1>
    <form @submit.prevent="login">
        <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="password" required />
      </div>


    
      <div>
        <button class="btn btn-primary" type="submit">Login</button>
        <p v-if="loginFailed" class="error-message">Invalid username or password.</p>
      </div>
     
    </form>
  </div>
  </div>


     
</template>

<script>
import { store } from "../store";
export default {
    data() {
    return {
      username: 'Validooo',
      password: 'Password',
      loginFailed: false,
    };
  },
  methods: {
    login() {
      // Hardcoded credentials for demonstration
      const validUsername = 'Validooo';
      const validPassword = 'Password';

      if (this.username === validUsername && this.password === validPassword) {
        // Successful login
        this.loginFailed = false;
        store.isAuthenticated = true;
        this.$router.push('/home');
        
      } else {
       
        this.loginFailed = true;
      }
    },
  },
}
</script>

<style>
.login-wrapper {
 position: relative;
    display: flex;
  justify-content: center;
  align-items: center;
  min-height: 85vh;

  /* Background color for the whole page */
}

.login-container {
  max-width: 800px;
  margin: auto;
 
  border: 1px solid #ccc;
   padding: 140px;
 
  border-radius: 5px;
}
 .loginhtwo{
    position: relative;
    left: 20px;
 }


label {
  width: 80px; /* Adjust the width as needed */
  margin-right: 15px;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
.form-group {
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}
</style>