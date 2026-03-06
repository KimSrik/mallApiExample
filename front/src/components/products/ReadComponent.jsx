import { useEffect, useState } from "react";
import { getOne } from "../../api/productsApi";
import { API_SERVER_HOST } from "../../api/todoApi";
import useCustomMove from "../../hooks/useCustomMove";
import FetchingModal from "../common/FetchingModal";

const initState = {
  pno : 0,
  pname : '',
  pdesc : '',
  price : 0,
  uploadFileNames : []
}

const host = API_SERVER_HOST;

const ReadComponent = ({pno}) => {
  const [product, setProduct] = useState(initState);

  const {moveToList, moveToModify} = useCustomMove();

  const [fetching, setFetching] = useState(false);

  useEffect( ()=> {
    setFetching(true);

    getOne(pno).then(data => {
      setProduct(data)
      setFetching(false)
    })
  }, [pno]);
  
  return (
    <div className="border-2 border-sky-200 mt-10 m-2 p-4">
      {fetching ? <FetchingModal></FetchingModal> : <></>}
      <div className="flex justify-center mt-10">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="">

          </div>
        </div>

      </div>

      <div className="w-full justify-center flex flex-col m-auto items-center">
        {product.uploadFileNames.map( (imgFile, i) => {
          <img alt="product" key={i} className="p-4 w-1/2" src={`${host}/api/products/view/${imgFile}`}></img>
        })}
      </div>

    </div>
  )
}

export default ReadComponent;