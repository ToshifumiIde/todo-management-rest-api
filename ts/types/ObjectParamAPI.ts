import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { RegisterUserDto } from '../front.restapi.tmregis.model/RegisterUserDto';
import { UserRole } from '../front.restapi.tmregis.model/UserRole';

import { ObservableTmregisApi } from "./ObservableAPI";
import { TmregisApiRequestFactory, TmregisApiResponseProcessor} from "../apis/TmregisApi";

export interface TmregisApiCreateRegisterRequest {
    /**
     * 
     * @type RegisterUserDto
     * @memberof TmregisApicreateRegister
     */
    registerUserDto?: RegisterUserDto
}

export class ObjectTmregisApi {
    private api: ObservableTmregisApi

    public constructor(configuration: Configuration, requestFactory?: TmregisApiRequestFactory, responseProcessor?: TmregisApiResponseProcessor) {
        this.api = new ObservableTmregisApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param param the request object
     */
    public createRegisterWithHttpInfo(param: TmregisApiCreateRegisterRequest = {}, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.createRegisterWithHttpInfo(param.registerUserDto,  options).toPromise();
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param param the request object
     */
    public createRegister(param: TmregisApiCreateRegisterRequest = {}, options?: Configuration): Promise<void> {
        return this.api.createRegister(param.registerUserDto,  options).toPromise();
    }

}
