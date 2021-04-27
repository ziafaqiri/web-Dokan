import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/add/people",
    name: "addpeople",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/addpeople.vue")
  },
  {
    path: "/Tools",
    name: "Tools",
    component: () =>
      import("../views/Tools.vue")
  },
  {
    path: "/sell",
    name: "sell",
    component: () =>
      import("../views/sell.vue")
  },
  {
    path: "/expenses",
    name: "expenses",
    component: () =>
      import("../views/expenses.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
