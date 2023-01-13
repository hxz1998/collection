declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

@str0 = constant[36 x i8] c"Enter index of Fibonacci sequence:\0A\00"
@str1 = constant[11 x i8] c"Solution:\0A\00"
define void @fibonacci() nounwind {
  %1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [36 x i8], [36 x i8]* @str0, i32 0, i32 0))
  %n = alloca i32
  store i32 0, i32* %n
  %2 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* %n)
  %solution = alloca i32
  %3 = load i32, i32* %n
  store i32 %3, i32* %solution
  %4 = load i32, i32* %n
  %5 = icmp eq i32 %4, 2
  br i1 %5, label %true1, label %false1
  true1:
  store i32 1, i32* %solution
  br label %false1
  false1:
  %grandparent = alloca i32
  store i32 1, i32* %grandparent
  %parent = alloca i32
  store i32 1, i32* %parent
  %6 = load i32, i32* %solution
  %7 = sitofp i32 %6 to double
  %8 = fsub double %7, 2.0
  %r = alloca double
  store double %8, double* %r
  %9 = load double, double* %r
  %10 = fptosi double %9 to i32
  %11 = alloca i32
  store i32 0, i32* %11
  br label %cond2
  cond2:
  %12 = load i32, i32* %11
  %13 = add i32 %12, 1
  store i32 %13, i32* %11
  %14 = icmp slt i32 %12, %10
  br i1 %14, label %true2, label %false2
  true2:
  %15 = load i32, i32* %parent
  %16 = sitofp i32 %15 to double
  %17 = load i32, i32* %grandparent
  %18 = sitofp i32 %17 to double
  %19 = fadd double %18, %16
  %20 = fptosi double %19 to i32
  store i32 %20, i32* %solution
  %21 = load i32, i32* %parent
  store i32 %21, i32* %grandparent
  %22 = load i32, i32* %solution
  store i32 %22, i32* %parent
  br label %cond2
  false2:
  %23 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [11 x i8], [11 x i8]* @str1, i32 0, i32 0))
  %24 = load i32, i32* %solution
  %25 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %24)
  ret void
}

@str2 = constant[43 x i8] c"Enter x to solve x^2 + 2*x + 10 equation:\0A\00"
@str3 = constant[11 x i8] c"Solution:\0A\00"
define void @arithmetic() nounwind {
  %1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [43 x i8], [43 x i8]* @str2, i32 0, i32 0))
  %x = alloca i32
  store i32 0, i32* %x
  %2 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* %x)
  %3 = load i32, i32* %x
  %4 = sitofp i32 %3 to double
  %5 = load i32, i32* %x
  %6 = sitofp i32 %5 to double
  %7 = fmul double %6, %4
  %8 = load i32, i32* %x
  %9 = sitofp i32 %8 to double
  %10 = fmul double %9, 2.0
  %11 = fadd double 10.0, %10
  %12 = fadd double %11, %7
  %s = alloca double
  store double %12, double* %s
  %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [11 x i8], [11 x i8]* @str3, i32 0, i32 0))
  %14 = load double, double* %s
  %15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %14)
  ret void
}

define i32 @main() nounwind {
  call void @fibonacci()
  call void @arithmetic()
  ret i32 0
}
