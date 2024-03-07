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
  return (
    <div className="card relative bg-white rounded-md shadow-md transition-transform ease-in duration-300 transform hover:shadow-lg hover:-translate-y-2">
      <img src={src} alt="" className="h-56 w-full object-fill rounded-t-md" />
      <div className="card-body p-4">
        <h5 className="text-xl font-semibold mb-2 text-gray-600">{nome}</h5>
        <p className="text-gray-600">{tamanho}</p>
        <p className="text-gray-600">{dataUpload}</p>
      </div>
    </div>
  );
};
