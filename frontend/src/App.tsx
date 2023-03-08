import { useState } from "react";
import CreateUser from "./CreateUser";
import UserCard from "./UserCard";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <CreateUser />
      <UserCard />
    </div>
  );
}

export default App;
