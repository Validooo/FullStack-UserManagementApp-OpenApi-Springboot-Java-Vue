<template>
  <nav class="navbar navbar-expand-md navbar-light bg-light">
    <a
      class="navbar-brand"
      href="https://validooo.github.io/FullStack-TodoManagement-App-React_Springboot-Java/"
      >TodoApp</a
    >
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse parent" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">


        <li class="nav-item" role="presentation" v-if="isAuthenticated">
          <router-link class="nav-link" to="/home">Home</router-link>
        </li>

        <li class="nav-item" role="presentation">
          <router-link class="nav-link" to="/user/-1" v-if="isAuthenticated">Add User</router-link>
        </li>
       

        <h2 class="child">Validooo</h2>
      </ul>
      <button class="btn btn-outline-dark" @click="signout()"  v-if="isAuthenticated">
      Sign Out
        </button>
    </div>
  </nav>
</template>

<script>
import { store } from "../store";
export default { data() {

    return {
      isAuthenticatedd: store.isAuthenticated
    }
  },  computed: {
    isAuthenticated() {
      return store.isAuthenticated; // Compute a value based on originalValue
    },
  },methods:{
    signout() {
      this.$router.push('/');
      store.isAuthenticated =false
    }
  }
}
  
</script>

<style>
.parent {
  position: relative;
  width: 100%; /* Set an appropriate width */
}

.child {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgb(200, 167, 202);
  padding: 5px;
  border: 1px solid gray;
}
</style>
