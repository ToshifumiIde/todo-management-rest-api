import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { RegisterUserDto } from '../front.restapi.tmregis.model/RegisterUserDto';
import { UserRole } from '../front.restapi.tmregis.model/UserRole';
import { ObservableTmregisApi } from './ObservableAPI';

import { TmregisApiRequestFactory, TmregisApiResponseProcessor} from "../apis/TmregisApi";
export class PromiseTmregisApi {
    private api: ObservableTmregisApi

    public constructor(
        configuration: Configuration,
        requestFactory?: TmregisApiRequestFactory,
        responseProcessor?: TmregisApiResponseProcessor
    ) {
        this.api = new ObservableTmregisApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param registerUserDto 
     */
    public createRegisterWithHttpInfo(registerUserDto?: RegisterUserDto, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.createRegisterWithHttpInfo(registerUserDto, _options);
        return result.toPromise();
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param registerUserDto 
     */
    public createRegister(registerUserDto?: RegisterUserDto, _options?: Configuration): Promise<void> {
        const result = this.api.createRegister(registerUserDto, _options);
        return result.toPromise();
    }


}



