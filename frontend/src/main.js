import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Vue from 'vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import "bootstrap"
import { store } from "./store";

createApp(App).use(router).use(store).mount("#app");
