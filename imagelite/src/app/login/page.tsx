"use client";

import {
  Template,
  RenderIf,
  InputText,
  Button,
  FieldError,
  useNotification,
} from "@/components";
import { useState } from "react";
import { LoginForm, formScheme, validationScheme } from "./formScheme";
import { useFormik } from "formik";
import { useAuth } from "@/resources";
import { useRouter } from "next/navigation";
import { AccessToken, Credentials } from "@/resources/user/users.resources";

export default function Login() {
  const [loading, setLoading] = useState<boolean>(false);
  const [newUserState, setNewUserState] = useState<boolean>(false);

  const auth = useAuth();
  const notificattion = useNotification();
  const router = useRouter();

  const { values, handleChange, handleSubmit, errors } = useFormik<LoginForm>({
    initialValues: formScheme,
    validationSchema: validationScheme,
    onSubmit: onSubmit,
  });

  async function onSubmit(values: LoginForm) {
    if (!newUserState) {
      const credentials: Credentials = {
        email: values.email,
        password: values.password,
      };

      try {
        const accessToken: AccessToken = await auth.authenticate(credentials);
        router.push("/galeria");
      } catch (error: any) {
        const message = error?.message;
        notificattion.notify(message, "error");
      }
    }
  }

  return (
    <Template loading={loading}>
      <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm">
          <h2 className="mt-10 text-center text-1x1 font-bold leading-9 tracking-tight text-gray-900">
            {newUserState ? "Create New User" : "Login to your account"}
          </h2>
        </div>
        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form onSubmit={handleSubmit} className="space-y-6">
            <RenderIf condition={newUserState}>
              <div>
                <label className="block text-sm font-medium leading-6 text-gray-600">
                  Name:
                </label>
                <div className="mt-2">
                  <InputText
                    style="w-full"
                    id="name"
                    value={values.name}
                    onChange={handleChange}
                  />
                </div>
                <FieldError error={errors.name} />
              </div>
            </RenderIf>
            <div>
              <label className="block text-sm font-medium leading-6 text-gray-600">
                Email:
              </label>
              <div className="mt-2">
                <InputText
                  style="w-full"
                  id="email"
                  value={values.email}
                  onChange={handleChange}
                />
              </div>
              <FieldError error={errors.email} />
            </div>
            <div>
              <label className="block text-sm font-medium leading-6 text-gray-600">
                Password:
              </label>
              <div className="mt-2">
                <InputText
                  style="w-full"
                  id="password"
                  type="password"
                  value={values.password}
                  onChange={handleChange}
                />
              </div>
              <FieldError error={errors.password} />
            </div>

            <RenderIf condition={newUserState}>
              <div>
                <label className="block text-sm font-medium leading-6 text-gray-600">
                  Repeat Password:
                </label>
                <div className="mt-2">
                  <InputText
                    style="w-full"
                    id="passwordMatch"
                    type="password"
                    value={values.passwordMatch}
                    onChange={handleChange}
                  />
                </div>
                <FieldError error={errors.passwordMatch} />
              </div>
            </RenderIf>
            <div>
              <RenderIf condition={newUserState}>
                <Button
                  type="submit"
                  style="bg-indigo-700 hover:bg-indigo-500"
                  label="Save"
                />
                <Button
                  type="button"
                  style="bg-red-700 hover:bg-red-500 mx-2"
                  label="Cancel"
                  onClick={(event) => setNewUserState(false)}
                />
              </RenderIf>
              <RenderIf condition={!newUserState}>
                <Button
                  type="submit"
                  style="bg-indigo-700 hover:bg-indigo-500"
                  label="Login"
                />
                <Button
                  type="button"
                  style="bg-red-700 hover:bg-red-500 mx-2"
                  label="Sing up"
                  onClick={(event) => setNewUserState(true)}
                />
              </RenderIf>
            </div>
          </form>
        </div>
      </div>
    </Template>
  );
}
