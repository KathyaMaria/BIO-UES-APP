<?php


namespace App\Http\Controllers\API;


use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Especimen;
use Validator;


class EspecimenController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $especimens = Especimen::all();


        return $this->sendResponse($especimens->toArray(), 'Especimenes recibidas con exito.');
    }


    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $input = $request->all();


        $validator = Validator::make($input, [
            'fechaColecta' => 'required',
            'horaSecuenciacion1' => 'required',
            'colector' => 'required',
            'latitud' => 'required',
            'longitud' => 'required',
            'tecnicaRecoleccion' => 'required',
            'cantidad' => 'required',
            'tipoMuestra' => 'required',
            'caracteristicas' => 'required',
            'peso' => 'required',
            'tamano' => 'required',
            'habitat' => 'required'
        ]);


        if($validator->fails()){
            return $this->sendError('Error de validacion.', $validator->errors());       
        }


        $especimen = Especimen::create($input);


        return $this->sendResponse($especimen->toArray(), 'Especimen creada.');
    }


    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $especimen = Especimen::find($id);


        if (is_null($especimen)) {
            return $this->sendError('Especimen no encontrada.');
        }


        return $this->sendResponse($especimen->toArray(), 'Especimen recibida con exito.');
    }


    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Especimen $especimen)
    {
        $input = $request->all();


        $validator = Validator::make($input, [
            'fechaColecta' => 'required',
            'horaSecuenciacion1' => 'required',
            'colector' => 'required',
            'latitud' => 'required',
            'longitud' => 'required',
            'tecnicaRecoleccion' => 'required',
            'cantidad' => 'required',
            'tipoMuestra' => 'required',
            'caracteristicas' => 'required',
            'peso' => 'required',
            'tamano' => 'required',
            'habitat' => 'required'
        ]);


        if($validator->fails()){
            return $this->sendError('Error de validacion.', $validator->errors());       
        }


        $especimen->fechaColecta = $input['fechaColecta'];
        $especimen->horaSecuenciacion1 = $input['horaSecuenciacion1'];
        $especimen->colector = $input['colector'];
        $especimen->latitud = $input['latitud'];
        $especimen->longitud = $input['longitud'];
        $especimen->tecnicaRecoleccion = $input['tecnicaRecoleccion'];
        $especimen->cantidad = $input['cantidad'];
        $especimen->tipoMuestra = $input['tipoMuestra'];
        $especimen->caracteristicas = $input['caracteristicas'];
        $especimen->peso = $input['peso'];
        $especimen->tamano = $input['tamano'];
        $especimen->habitat = $input['habitat'];
        $especimen->save();


        return $this->sendResponse($especimen->toArray(), 'Especimen actualizada con exito.');
    }


    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Especimen $especimen)
    {
        $especimen->delete();


        return $this->sendResponse($especimen->toArray(), 'Especimen eliminado con exito.');
    }
}