import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import(/* webpackChunkName: "about" */ '../views/Manage.vue'),
    redirect: "/home",
    children: [
      {path: 'home', name: 'Home', component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')},
      {path: 'user', name: 'User', component: () => import(/* webpackChunkName: "about" */ '../views/User.vue')},
      {path: '/jiqun1', name: 'Jiqun1', component: () => import(/* webpackChunkName: "about" */ '../views/Jiqun1.vue')},
      {path: '/download', name: 'Download', component: () => import(/* webpackChunkName: "about" */ '../views/Download.vue')},
      {path: '/validation', name: 'Validation', component: () => import(/* webpackChunkName: "about" */ '../views/Validation.vue')},
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue'),
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import(/* webpackChunkName: "about" */ '../views/Register.vue')
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
