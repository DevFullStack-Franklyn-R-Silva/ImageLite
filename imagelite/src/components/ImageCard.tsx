"use client";

interface ImageCardProps {
  nome?: string;
  tamanho?: string;
  dataUpload?: string;
  src?: string;
}

export const ImageCard: React.FC<ImageCardProps> = ({
  nome,
  tamanho,
  dataUpload,
  src,
}: ImageCardProps) => {
  function download() {
    window.open(src, "_blank");
  }

  return (
    <div className="card relative bg-white rounded-md shadow-md transition-transform ease-in duration-300 transform hover:shadow-lg hover:-translate-y-2">
      <img src={src} alt="" className="h-56 w-full object-fill rounded-t-md" />
      <div className="card-body p-4">
        <h5 className="text-xl font-semibold mb-2 text-gray-600">{nome}</h5>
        <p className="text-gray-600">{tamanho}</p>
        <p className="text-gray-600">{dataUpload}</p>
        <svg
          onClick={download}
          className="h-8 w-8 text-gray-400  hover:text-black"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M4 16v1a3 3 0 003 3h10a3 3 0 003-3v-1m-4-4l-4 4m0 0l-4-4m4 4V4"
          />
        </svg>
      </div>
    </div>
  );
};
