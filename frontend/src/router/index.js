import { createRouter, createWebHistory } from "vue-router";
import UserList from "../views/UserList.vue";
import AddEditUser from "../views/AddEditUser.vue";
import Login from "../views/Login.vue"
import { store } from "../store"
const routes = [
  {
    path: "/",
    name: "login",
    component: Login,
    meta: { requiresAuth: false },
  },
{
path:"/home",
name:"home",
component: UserList,
meta: { requiresAuth: true },
},

  {
    path: "/user/:id",
    name: "adduser",
    component: AddEditUser,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});



router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !store.state.isAuthenticated) {
    // If the route requires authentication and the user is not authenticated
    next('/'); // Redirect to login page
  } else {
    next(); // Proceed to the route
  }
});


export default router;
