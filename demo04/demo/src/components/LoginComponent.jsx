import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function LoginComponent() {
  const [username, setUsername] = useState("defaultUser");
  const [password, setPassword] = useState("");
  const [showErrorMessage, setShowErrorMessage] = useState(false);
  const [showValidMessage, setShowValidMessage] = useState(false);

  const navigate = useNavigate();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleSubmit() {
    if (authenticateUser()) {
      navigate(`/home/${username}`);
    }
  }

  function authenticateUser() {
    if (username === "defaultUser" && password === "") {
      setShowErrorMessage(false);
      setShowValidMessage(true);
      return true;
    }

    setShowErrorMessage(true);
    setShowValidMessage(false);
    return false;
  }

  return (
    <div className="Login">
      <div className="LoginForm">
        {showValidMessage && <div>Authenticated!</div>}
        {showErrorMessage && <div>Authenticated failed!</div>}

        <div>
          <label htmlFor="username">Username</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}
