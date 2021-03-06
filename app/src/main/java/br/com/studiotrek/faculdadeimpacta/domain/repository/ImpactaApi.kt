package br.com.studiotrek.faculdadeimpacta.domain.repository

import br.com.studiotrek.faculdadeimpacta.domain.entity.CookieDTO
import br.com.studiotrek.faculdadeimpacta.domain.entity.gradesAbsence.GradesAbsenceRequest
import br.com.studiotrek.faculdadeimpacta.domain.entity.gradesAbsence.GradesAbsenceResponse
import br.com.studiotrek.faculdadeimpacta.domain.entity.home.HomeScheduleResponse
import br.com.studiotrek.faculdadeimpacta.domain.entity.login.LoginResponse
import br.com.studiotrek.faculdadeimpacta.domain.entity.schedule.ScheduleResponse
import br.com.studiotrek.faculdadeimpacta.domain.entity.semesterGrades.SemesterResponse
import retrofit2.Response
import retrofit2.http.*
import rx.Observable

/**
 * Created by Wilder on 18/02/18.
 */

interface ImpactaApi {

    //TODO: create response class
    @GET("login/{ra}/{password}")
    fun login(@Path("ra") ra: String, @Path("password") password: String): Observable<Response<LoginResponse>>

    //TODO: Change jsonobject to appropriate classes
    @POST("v2/horario")
    fun getClassesSchedule(@Header("token") token: String): Observable<Response<List<ScheduleResponse>>>

    //TODO: Change jsonobject to appropriate classes
    @POST("v2/semestre-nota")
    fun getSemesterGrades(@Header("token") token: String): Observable<Response<SemesterResponse>>

    @POST("v2/nota-falta")
    fun getGradesAbsence(@Header("token") token: String, @Body gradesAbsenceRequest: GradesAbsenceRequest) : Observable<Response<GradesAbsenceResponse>>

    @POST("v2/aula-dia")
    fun getHome(@Header("token") token: String) : Observable<Response<HomeScheduleResponse>>
}