"use client";

import { Template, RenderIf, InputText } from "@/components";
import { useState } from "react";

export default function Login() {
  const [loading, setLoading] = useState<boolean>(false);
  const [newUserState, setNewUserState] = useState<boolean>(false);

  return (
    <Template loading={loading}>
      <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm">
          <h2 className="mt-10 text-center text-1x1 font-bold leading-9 tracking-tight text-gray-900">
            Login to your account
          </h2>
        </div>
        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6">
            <RenderIf condition={newUserState}>
              <div>
                <label className="block text-sm font-medium leading-6 text-gray-600">
                  Name:
                </label>
                <div className="mt-2">
                  <InputText style="w-full" id="name" />
                </div>
              </div>
            </RenderIf>
            <div>
              <label className="block text-sm font-medium leading-6 text-gray-600">
                Email:
              </label>
              <div className="mt-2">
                <InputText style="w-full" id="email" />
              </div>
            </div>
            <div>
              <label className="block text-sm font-medium leading-6 text-gray-600">
                Password:
              </label>
              <div className="mt-2">
                <InputText style="w-full" id="password" type="password" />
              </div>
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
                  />
                </div>
              </div>
            </RenderIf>
          </form>
        </div>
      </div>
    </Template>
  );
}
