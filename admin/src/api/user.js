import request, { BASE_URL } from '@/utils/request'

export function login(data) {
  return request({
    url: '/vue-admin-template/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/vue-admin-template/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}

export function delUser(id) {
  return request({
    url: `${BASE_URL}/user/del/${id}`,
    method: 'delete'
  })
}

export function saveUser(data) {
  return request({
    url: BASE_URL + '/user/saveOrUpdate',
    method: 'post',
    data
  })
}

export function userList() {
  return request({
    url: BASE_URL + '/user/list'
  })
}

export function userLogin(data) {
  return request({
    url: BASE_URL + '/user/login',
    method: 'post',
    data
  })
}

export function getUser(id) {
  return request({
    url: `${BASE_URL}/user/get/${id}`
  })
}

export function findPwd(data) {
  return request({
    url: `${BASE_URL}/user/findPwd`,
    method: 'post',
    data
  })
}
