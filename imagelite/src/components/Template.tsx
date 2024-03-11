import { ToastContainer } from "react-toastify";

interface TemplateProps {
  children?: React.ReactNode;
  loading?: boolean;
}

export const Template: React.FC<TemplateProps> = ({
  children,
  loading = false,
}: TemplateProps) => {
  return (
    <>
      <Header />
      <div
        className={`${
          loading ? "animate-pulse" : ""
        } container mx-auto mt-8 px-4`}
      >
        <RenderIf condition={loading}>
          <div className="flex items-center justify-center">
            <Loading />
          </div>
        </RenderIf>
        {children}
      </div>
      <Footer />
      <ToastContainer
        position="top-right"
        autoClose={8000}
        hideProgressBar={false}
        draggable={false}
        closeOnClick={true}
        pauseOnHover={true}
      />
    </>
  );
};

interface RenderIfProps {
  condition?: boolean;
  children: React.ReactNode;
}

export const RenderIf: React.FC<RenderIfProps> = ({
  condition = true,
  children,
}: RenderIfProps) => {
  return condition ? children : false;
};

const Loading: React.FC = () => {
  return (
    <>
      <div className="animate-spin rounded-full h-8 w-8 border-t-2 border-blue-500 border-solid mr-3"></div>
      <span className="text-gray-600 font-semibold">Carregando...</span>
    </>
  );
};

const Header: React.FC = () => {
  return (
    <header className="bg-indigo-950 text-white py-3">
      <div className="container mx-auto flex justify-between items-center px-4">
        <h1 className="text3xl font-bold">ImageLite</h1>
      </div>
    </header>
  );
};

const Footer: React.FC = () => {
  return (
    <footer className="bg-indigo-950 text-white py-4 mt-8">
      <div className="container mx-auto text-center">
        Desenvolvido por Franklyn Roberto
      </div>
    </footer>
  );
};
