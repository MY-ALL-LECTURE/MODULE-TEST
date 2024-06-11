package com.example.app.controller.movie;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MovieDto;
import com.example.app.domain.common.service.MovieService;
import com.example.app.domain.common.service.MovieServiceImpl;

public class MovieUpdateController implements SubController {

//    private MovieService movieService;
//    private ConnectionPool connectionPool;
//
//    public MovieUpdateController() {
//        try {
//            movieService = MovieServiceImpl.getInstance();
//            connectionPool = ConnectionPool.getInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("MovieUpdateController's execute() invoked ");
//
//        try {
//            // GET 요청
//            String method = request.getMethod();
//            if (method.contains("GET")) {
//                // 영화 ID를 request에 설정하여 JSP로 전달
//                String movieIdStr = request.getParameter("movieId");
//                int movieId = Integer.parseInt(movieIdStr);
//                MovieDto movie = movieService.getMovieById(movieId);
//                request.setAttribute("movie", movie);
//                request.getRequestDispatcher("/WEB-INF/view/movie/update.jsp").forward(request, response);
//                return;
//            }
//
//            // POST 요청
//            if (method.equalsIgnoreCase("POST")) {
//                String movieIdStr = request.getParameter("movieId");
//                int movieId;
//                try {
//                    movieId = Integer.parseInt(movieIdStr);
//                } catch (NumberFormatException e) {
//                    // movieId가 숫자로 변환할 수 없는 경우에 대한 처리
//                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movieId format.");
//                    return; // 에러 응답 후 메서드 종료
//                }
//                String movieTitle = request.getParameter("movieTitle");
//                String movieGenre = request.getParameter("movieGenre");
//                String reserv = request.getParameter("reserv");
//                String cgv = request.getParameter("cgv");
//                String time = request.getParameter("time");
//
//                // 유효성 검사
//                if (isValid(movieIdStr, movieTitle, movieGenre, reserv, cgv, time)) {
//                    // 영화 정보 업데이트
//                    MovieDto movieDto = new MovieDto(movieId, movieTitle, movieGenre,
//                            Boolean.parseBoolean(reserv), cgv, time);
//                    boolean isUpdated = movieService.updateMovie(movieDto);
//
//                    if (isUpdated) {
//                        // 업데이트가 성공하면 영화 목록 페이지로 리다이렉트
//                        response.sendRedirect(request.getContextPath() + "/movie/list");
//                        return; // 리다이렉트 후 메서드 종료
//                    } else {
//                        // 업데이트 실패 시 에러 응답 반환
//                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to update movie.");
//                        return; // 에러 응답 후 메서드 종료
//                    }
//                }
//
//                // 유효성 검사에 실패한 경우에도 에러 응답 반환
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data.");
//                return; // 에러 응답 후 메서드 종료
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 예외가 발생하면 롤백을 시도
//            try {
//                connectionPool.txRollBack();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//
//            // 예외가 발생한 경우에도 에러 응답 반환
//            try {
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error.");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//	private boolean isValid(String movieIdStr, String movieTitle, String movieGenre, String reserv, String cgv,
//			String time) {    // 영화 ID가 유효한지 확인
//	    if (movieIdStr == null || movieIdStr.isEmpty()) {
//	        return false;
//	    }
//
//	    // 영화 제목이 유효한지 확인
//	    if (movieTitle == null || movieTitle.isEmpty()) {
//	        return false;
//	    }
//
//	    // 영화 장르가 유효한지 확인
//	    if (movieGenre == null || movieGenre.isEmpty()) {
//	        return false;
//	    }
//
//	    // 예매 여부가 유효한지 확인
//	    if (reserv == null || reserv.isEmpty()) {
//	        return false;
//	    }
//
//	    // 상영 장소가 유효한지 확인
//	    if (cgv == null || cgv.isEmpty()) {
//	        return false;
//	    }
//
//	    // 상영 시간이 유효한지 확인
//	    if (time == null || time.isEmpty()) {
//	        return false;
//	    }
//
//	    // 모든 유효성 검사를 통과하면 true 반환
//	    return true;
	}
}
