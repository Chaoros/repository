import request, { BASE_URL } from '@/utils/request'

export function commodityList() {
  return request({
    url: BASE_URL + '/commodity/list'
  })
}

export function delCommodity(id) {
  return request({
    url: `http://localhost:8081/commodity/del/${id}`,
    method: 'delete'
  })
}

export function insertCommodity(data) {
  return request({
    url: BASE_URL + '/commodity/insert',
    method: 'post',
    data
  })
}

export function categoryCharts() {
  return request({
    url: BASE_URL + '/commodity/category/charts'
  })
}

export function repositoryCharts(data) {
  return request({
    url: BASE_URL + '/commodity/repository/charts',
    params: {
      ...data
    }
  })
}
