import React from 'react';
import ReactDom from 'react-dom/client';
import './index.css'
import App from './App.jsx'

import { Provider } from "react-redux"
import store from './store.js'

const root = ReactDom.createRoot(document.getElementById('root'));
root.render(
    <Provider store={store}>
        <App></App>
    </Provider>
)

// <strictmode>를 삭제함으로써 두번씩 실행되는 것을 방지함
