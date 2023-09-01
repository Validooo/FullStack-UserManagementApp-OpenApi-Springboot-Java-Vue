
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
}, mutations:{
  changeAuthentication(state,status){
    state.isAuthenticated = status
  },
  changeCountIds(state,newCount){
    state.countIds= newCount
  },
  changeNewUserCreatedStatus(state,status){
    state.newUserCreated = status
  },changeUpdatedUserId(state,id){
    state.updatedUserId = id
  },
  addNewUser(state,newUser){
    state.users.push(newUser)
  }, updateUser(state,user){
 const index =   state.users.findIndex((element) => element.id.toString() === user.id);
    state.users[index] = user
  }, deleteUser(state,id){
   
state.users=    state.users.filter(element => element.id !== id)
  }
}


});
