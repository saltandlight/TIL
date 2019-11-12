from django.shortcuts import render

# Create your views here.
# 무조건 첫째 파라미터는 request가 되어야 함
def lotto(request):
    
    return render(request, 'lotto.html')

def winning(request):

    return render(request, 'winning.html')
