import { createRouter, createWebHistory } from "vue-router";
import UserList from "../views/UserList.vue";
import AddEditUser from "../views/AddEditUser.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: UserList,
  },
  {
    path: "/user/:id",
    name: "adduser",
    component: AddEditUser,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
