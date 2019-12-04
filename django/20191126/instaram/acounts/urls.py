from django.urls import path
from . import views as acounts_view

app_name='acounts'

urlpatterns = [
    path('login/', acounts_view.login, name="login"),
    path('logout/', acounts_view.logout, name="logout"),
    path('signup/', acounts_view.signup, name="signup"),
]