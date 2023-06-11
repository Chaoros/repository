import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    hidden: true,
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: () => import('@/views/dashboard/index'),
        meta: { title: 'Dashboard', icon: 'dashboard' }
      },
      {
        path: 'profile',
        name: 'Profile',
        component: () => import('@/views/profile/index')
      }
    ]
  },

  {
    path: '/report',
    component: Layout,
    redirect: '/report/table',
    name: 'Report',
    meta: { title: '报表统计', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/report/commodity'),
        meta: { title: '货品查询' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/report/early'),
        meta: { title: '库存预警' }
      }
    ]
  },
  {
    path: '/base',
    component: Layout,
    redirect: '/base/commodity',
    name: 'Base',
    meta: { title: '基础设置', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'commodity',
        name: 'Commodity',
        component: () => import('@/views/base/commodity'),
        meta: { title: '新增货品' }
      },
      {
        path: 'user',
        name: 'User',
        component: () => import('@/views/base/user'),
        meta: { title: '用户管理' }
      },
      {
        path: 'warehouse/form',
        name: 'warehouseForm',
        component: () => import('@/views/warehouse/form'),
        meta: { title: '新增仓库' }
      },
      {
        path: 'warehouse/list',
        name: 'warehouseList',
        component: () => import('@/views/warehouse/list'),
        meta: { title: '仓库管理' }
      },
      {
        path: 'customer/form',
        name: 'customerFormPage',
        component: () => import('@/views/customer/form'),
        meta: { title: '新增客户' }
      },
      {
        path: 'customer/list',
        name: 'customerListPage',
        component: () => import('@/views/customer/list'),
        meta: { title: '客户管理' }
      }
      /* {
        path: 'tree',
        name: 'RepositoryTree',
        component: () => import('@/views/base/tree'),
        meta: { title: '仓库货物' }
      } */
    ]
  },
  {
    path: '/delivery',
    component: Layout,
    redirect: '/delivery/list',
    name: 'Delivery',
    meta: { title: '出库管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'list',
        name: 'List',
        component: () => import('@/views/delivery/list'),
        meta: { title: '出库列表' }
      },
      {
        path: 'form',
        name: 'Form',
        component: () => import('@/views/delivery/form'),
        meta: { title: '出库表单' }
      }
    ]
  },
  {
    path: '/put',
    component: Layout,
    redirect: '/put/list',
    name: 'Put',
    meta: { title: '入库管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'list',
        name: 'List',
        component: () => import('@/views/put/list'),
        meta: { title: '入库列表' }
      },
      {
        path: 'form',
        name: 'Form',
        component: () => import('@/views/put/form'),
        meta: { title: '入库表单' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () =>
  new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
  })

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
