// Dispatcher Servlet (Front Controller) 역할
import { createBrowserRouter } from "react-router-dom";
import { Suspense, lazy } from "react";
import todoRouter from "./todoRouter";
import productsRouter from "./productsRouter";
import memberRouter from "./memberRouter";

const Loading = <div>Loading...</div>;

// lazy() 지연 로딩.
// 데이터가 다 들어와야 로딩이 된다.
const Main = lazy( () => import("../pages/MainPage") );
const About = lazy( () => import("../pages/AboutPage") );
const TodoIndex = lazy ( () => import("../pages/todo/IndexPage") );

const ProductsIndex = lazy ( () => import("../pages/products/IndexPage") );



const root = createBrowserRouter([
    {
        path:"",
        element:<Suspense fallback={Loading}><Main></Main></Suspense>
    },
    {
        path:"about",
        element:<Suspense fallback={Loading}><About></About></Suspense>
    },
    {
        path:"todo",
        element:<Suspense fallback={Loading}><TodoIndex></TodoIndex></Suspense>,
        children:todoRouter()
    },
    {
        path:"products",
        element:<Suspense fallback={Loading}><ProductsIndex></ProductsIndex></Suspense>,
        children:productsRouter()
    },
    {
        path:"member",
        children:memberRouter()
    }

]);

export default root;