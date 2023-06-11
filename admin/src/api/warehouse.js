import request, { BASE_URL } from '@/utils/request'

export function warehouseList() {
  return request({
    url: BASE_URL + '/warehouse/list',
    method: 'get'
  })
}

export function delWarehouse(id) {
  return request({
    url: BASE_URL + '/warehouse/del/' + id,
    method: 'delete'
  })
}

export function saveWarehouse(data) {
  return request({
    url: BASE_URL + '/warehouse/save',
    method: 'post',
    data
  })
}
