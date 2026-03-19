import axios from "axios";
import { redirect } from "react-router-dom";

const rest_api_key = `9a9ce9b5f978d806ed110565194b0973`;
const redirect_uri = `http://localhost:5173/member/kakao`;
const auth_code_path = `https://kauth.kakao.com/oauth/authorize`;

const access_token_url = `https://kauth.kakao.com/oauth/token`;

export const getKakaoLoginLink = () => {
  const kakaoURL = `${auth_code_path}?client_id=${rest_api_key}&redirect_uri=${redirect_uri}&response_type=code`;

  return kakaoURL;
}

export const getAccessToken = async (authCode) => {
  
  const header = {
    headers:{
      "Content-Type":"application/x-www-form-urlencoded;charset=utf-8",
    }
  }

  const params = new URLSearchParams();

  params.append("grant_type", "authorization_code");
  params.append("client_id", rest_api_key);
  params.append("redirect_url", redirect_uri);
  params.append("code", authCode);
  params.append("client_secret", "Ik0cCZuygA7czJyxsC4SUrHbQY6596Ag");

  const res = await axios.post(access_token_url, params, header);

  const accessToken = res.data.access_token;

  return accessToken;

}