import request from '@/utils/request'

export function getUsersList(params) {
  return request({
    url: '/users/getallusers',
    method: 'get',
    params
  })
}

export function getPageInfo(params) {
  return request({
    url: '/users/getPageInfo',
    method: 'get',
    params: params
  })
}

export function deleteUsers(username) {
  return request({
    url: '/users/deleteusers?username=' + username,
    method: 'delete'
  })
}

export function updateUsers(usersBean) {
  return request({
    url: '/users/updateusers',
    method: 'put',
    data: usersBean
  })
}

export function insertUsers(usersBean) {
  return request({
    url: '/users/insertusers',
    method: 'post',
    data: usersBean
  })
}
