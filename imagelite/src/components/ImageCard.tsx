"use client";

import { ButtonSVG } from "./buttton";

interface ImageCardProps {
  nome?: string;
  tamanho?: number;
  dataUpload?: string;
  src?: string;
  extension?: string;
}

export const ImageCard: React.FC<ImageCardProps> = ({
  nome,
  tamanho,
  dataUpload,
  src,
  extension,
}: ImageCardProps) => {
  function download() {
    window.open(src, "_blank");
  }

  return (
    <div className="card relative bg-white rounded-md shadow-md transition-transform ease-in duration-300 transform hover:shadow-lg hover:-translate-y-2">
      <img src={src} alt="" className="h-56 w-full object-fill rounded-t-md" />
      <div className="card-body p-4">
        <h5 className="text-xl font-semibold mb-2 text-gray-600">{nome}</h5>
        <p className="text-gray-600">{extension}</p>
        <p className="text-gray-600">{formatBytes(tamanho)}</p>
        <p className="text-gray-600">{dataUpload}</p>
        <ButtonSVG
          style="h-8 w-8"
          onClick={download}
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          strokeLinecap="round"
          strokeLinejoin="round"
          strokeWidth="2"
          d="M4 16v1a3 3 0 003 3h10a3 3 0 003-3v-1m-4-4l-4 4m0 0l-4-4m4 4V4"
        />
      </div>
    </div>
  );
};

function formatBytes(bytes: number = 0, decimals = 2) {
  if (isNaN(bytes)) return "0 Bytes";

  const k = 1024;
  const dm = decimals < 0 ? 0 : decimals;
  const sizes = ["Bytes", "KB", "MB", "GB"];

  const i = Math.floor(Math.log(bytes) / Math.log(k));

  return `${(bytes / Math.pow(k, i)).toFixed(dm)} ${sizes[i]}`;
}
