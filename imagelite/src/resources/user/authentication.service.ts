import {
  User,
  Credentials,
  AccessToken,
  UserSessionToken,
} from "./users.resources";

class AuthService {
  baseURL: string = "http://localhost:8080/v1/users";
  static AUTH_PARAM: string = "_auth";

  async authenticate(credentials: Credentials): Promise<AccessToken> {
    const response = await fetch(this.baseURL + "/auth", {
      method: "POST",
      body: JSON.stringify(credentials),
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (response.status == 401) {
      throw new Error("User or password are incorrect!");
    }

    return await response.json();
  }

  async save(user: User): Promise<void> {
    const response = await fetch(this.baseURL, {
      method: "POST",
      body: JSON.stringify(user),
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (response.status == 409) {
      const responseError = await response.json();
      throw new Error(responseError.error);
    }
  }
}

export const useAuth = () => new AuthService();
