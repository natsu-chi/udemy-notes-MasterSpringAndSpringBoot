import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./Layout.css";
import LoginComponent from "./LoginComponent";
import HeaderComponent from "./HeaderComponent";
import FooterComponent from "./FooterComponent";
import LogoutComponent from "./LogoutComponent";
import HomeComponent from "./HomeComponent";
import ListTodosComponent from "./ListTodosComponent";
import ErrorComponent from "./ErrorComponent";
import AuthProvider from "./security/AuthContext";


export default function Layout() {
  return (
    <div className="Layout">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />

          <Routes>
            <Route path="/" element={<LoginComponent />}></Route>
            <Route path="/login" element={<LoginComponent />}></Route>
            <Route path="/home/:username" element={<HomeComponent />}></Route>
            <Route path="/todos" element={<ListTodosComponent />} />
            <Route path="/logout" element={<LogoutComponent />} />

            <Route path="*" element={<ErrorComponent />}></Route>
          </Routes>

          <FooterComponent />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}
