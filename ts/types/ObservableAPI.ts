import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { RegisterUserDto } from '../front.restapi.tmregis.model/RegisterUserDto';
import { UserRole } from '../front.restapi.tmregis.model/UserRole';

import { TmregisApiRequestFactory, TmregisApiResponseProcessor} from "../apis/TmregisApi";
export class ObservableTmregisApi {
    private requestFactory: TmregisApiRequestFactory;
    private responseProcessor: TmregisApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: TmregisApiRequestFactory,
        responseProcessor?: TmregisApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new TmregisApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new TmregisApiResponseProcessor();
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param registerUserDto 
     */
    public createRegisterWithHttpInfo(registerUserDto?: RegisterUserDto, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.createRegister(registerUserDto, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.createRegisterWithHttpInfo(rsp)));
            }));
    }

    /**
     * ユーザー登録を実施する [機能ID] TMREGIS01
     * @param registerUserDto 
     */
    public createRegister(registerUserDto?: RegisterUserDto, _options?: Configuration): Observable<void> {
        return this.createRegisterWithHttpInfo(registerUserDto, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

}
