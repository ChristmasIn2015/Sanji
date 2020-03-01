// 1.  导入变换组件
import login from "../views/login/login";
import index from "../views/Index";
import qrResult from "../views/qrCode/qrCodeResult";

// 2.  创建路由明细
const myRoutes = {
    mode: "history",
    routes: [
        {
            path: "/",
            name: "qrResult",
            component: qrResult
        },
        {
            path: "/login",
            name: "login",
            component: login
        },
        {
            path: "/index",
            name: "index",
            component: index
        }
    ]
};
export default myRoutes;
