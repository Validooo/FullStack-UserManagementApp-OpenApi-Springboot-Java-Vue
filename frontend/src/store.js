
import { createStore } from 'vuex'

export const store = createStore({
 state: {  users: [
    { id: 1, name: "John", age: 25, email: "John@gmail.com" },
    { id: 2, name: "Paul", age: 30, email: "Paul@gmail.com" },
    { id: 3, name: "Ronald", age: 28, email: "Ronald@mail.de" },
  ],
  countIds: 3,
  updatedUserId: -1,
  newUserCreated: false,
  isAuthenticated:false,

}
,
getters:{
  getusers(state){
    return state.users;
  },
  getCountIds(state){
    return state.countIds
  },
  getUpdatedUserId(state){
    return state.updatedUserId
  },
  newUserCreatedCheck(state){
    return state.newUserCreated
  },
  isAuthenticatedCheck(state){
    return state.isAuthenticated
  }
}


});
