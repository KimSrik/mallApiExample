import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
    <App />
)

// <strictmode>를 삭제함으로써 두번씩 실행되는 것을 방지함
