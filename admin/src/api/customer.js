import request, { BASE_URL } from '@/utils/request'

export function customerList() {
  return request({
    url: BASE_URL + '/customer/list',
    method: 'get'
  })
}

export function delCustomer(id) {
  return request({
    url: BASE_URL + '/customer/del/' + id,
    method: 'delete'
  })
}

export function saveCustomer(data) {
  return request({
    url: BASE_URL + '/customer/save',
    method: 'post',
    data
  })
}
