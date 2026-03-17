import axios from "axios";

const jwtAxios = axios.create();

const beforeReq = (config) => {
  console.log("before request ..........");

  return config;
}

const requestFail = (err) => {
  console.log("request fail ..........");

  return Promise.reject(err);
}

const beforeRes = async (res) => {
  console.log("before return Response ..........");

  return res;
}

const responseFail = (err) => {
  console.log("response fail error ..........");

  return Promise.reject(err);
}

jwtAxios.interceptors.request.use(beforeReq, requestFail);

jwtAxios.interceptors.response.use(beforeRes, responseFail);

export default jwtAxios;