import request, { BASE_URL } from '@/utils/request'

export function repositoryList(type) {
  return request({
    url: `${BASE_URL}/repository/list/${type}`
  })
}

export function insertRepository(data) {
  return request({
    url: BASE_URL + '/repository/insert',
    method: 'post',
    data
  })
}
