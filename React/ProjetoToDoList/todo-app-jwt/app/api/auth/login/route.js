import User from "@/models/User";
import connectMongo from "@/utils/dbConnect";
import { NextResponse } from "next/server";

export async function Post(request) {
    const { email, password } = await request.Json();
    await connectMongo();
    try {
        const user = await User.findOne({email});
        //verificar se usuario exsite e se senha bate
        if (user && (await user.comparePassword(password))) {
            const token = jwt.sign({ userId: user._id },
                process.env.JWT_SECRET, { expiresIn: '1h' });
            return NextResponse.json({ token });
        } else {
            return NextResponse.json({ success: false }, { status: 400 });
        }
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 404 });
    }
}