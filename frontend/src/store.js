import { reactive } from "vue";

export const store = reactive({
  user: [
    { id: 1, name: "John", age: 25, email: "John@gmail.com" },
    { id: 2, name: "Paul", age: 30, email: "Paul@gmail.com" },
    { id: 3, name: "Ronald", age: 28, email: "Ronald@mail.de" },
  ],
  id: 3,
  updatedUserId: -1,
  newUserCreated: false,
  isAuthenticated: false
});
