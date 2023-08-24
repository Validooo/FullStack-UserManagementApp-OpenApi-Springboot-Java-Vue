import { createRouter, createWebHistory } from 'vue-router'
import UserList from '../views/UserList.vue'
import AddUser from '../views/AddUser.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: UserList
  },
  {
    path: '/adduser',
    name: 'adduser',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: AddUser
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
