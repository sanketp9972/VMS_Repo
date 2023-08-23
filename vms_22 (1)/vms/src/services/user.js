import axios from 'axios'
import { createUrl, log } from '../utils/utils'

export async function registerUser(
  firstName,
  lastName,
  address,
  phone,
  email,
  password,
  userRoles

) {
  const url = createUrl('/users')
  const body = {
    firstName,
    lastName,
    address,
    phone,
    email,
    password,
    userRoles
  }

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body)
    log(response.data)
    return response.data
  } catch (ex) {
    log(ex)
    return null
  }
}
