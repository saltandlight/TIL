
from django.urls import path

from . import views as boards_views

urlpatterns = [
    path('', boards_views.index),
    # 게시판의 메인 페이지, 전체 리스트 페이지
    path('new/', boards_views.new),
    path('create/', boards_views.create),
    # 게시판의 글 하나하나를 보는 페이지
    path('<int:id>/', boards_views.show),
    #edit은 그냥 창임
    path('<id>/edit/', boards_views.edit),
    path('<id>/update/', boards_views.update),
    path('<id>/delete/', boards_views.delete), 
]
