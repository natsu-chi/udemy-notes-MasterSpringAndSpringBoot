import { useParams, Link } from "react-router-dom";

export default function HomeComponent() {
    const { username } = useParams();
  
    // console.log(username);
  
    return (
      <div className="HomeComponent">
        <h1>Welcome {username}</h1>
        <div>HomeComponent - <Link to="/todos">Go here</Link></div>
      </div>
    );
  }