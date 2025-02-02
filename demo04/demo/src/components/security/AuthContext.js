import { createContext, useState, useContext } from "react";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({children}) {
    
    const [number, setNumber] = useState(0);

    const [isAuthenticated, setAuthenticated] = useState(false);

    // setInterval( () => setNumber(number+1), 10000);

    // const valueToBeShared = {number, isAuthenticated, setAuthenticated};

    return (
        <AuthContext.Provider value={ {number, isAuthenticated, setAuthenticated} }>
            {children}
        </AuthContext.Provider>
    )
}