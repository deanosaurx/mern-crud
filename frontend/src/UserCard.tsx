import { useState, useEffect } from "react";

function UserCard() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3000/users")
      .then((response) => response.json())
      .then((data) => setUsers(data))
      .catch((error) => console.error(error));
  }, [users]);

  return (
    <div className="user-card">
      {users.map((user: any) => (
        <div className="card">
          <p>{user.name}</p>
          <p>{user.email}</p>
        </div>
      ))}
    </div>
  );
}

export default UserCard;
